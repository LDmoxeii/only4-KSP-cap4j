package com.only4.domain.aggregates.member;

import com.only4._share.exception.KnownException;
import lombok.val;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisor;
import org.netcorepal.cap4j.ddd.domain.event.DomainEventSupervisorSupport;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberTest {

    @Spy
    private Member member;

    @Mock
    private MemberStatistics memberStatistics;

    @Mock
    private Favorites favorites;

    @Mock
    private FollowMember followMember;

    @Mock
    private BlockMember blockMember;

    @Mock
    private DomainEventSupervisor eventSupervisor;

    @Nested
    class RegisterTests {
        @Test
        void testRegisterWithPassword() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                member.registerWithPassword();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }

        @Test
        void testRegisterWithPhone() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                member.registerWithPhone();

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateInfoTests {
        @Test
        void testUpdateInfo() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                String newNickName = "New NickName";
                String newSignature = "New Signature";

                member.updateInfo(newNickName, newSignature);

                assertAll(
                        () -> assertEquals(newNickName, member.getNickName()),
                        () -> assertEquals(newSignature, member.getSignature())
                );

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdatePhoneTests {
        @Test
        void testUpdatePhone() {
            String newPhone = "1234567890";

            member.updatePhone(newPhone);

            assertEquals(newPhone, member.getPhone());
        }
    }

    @Nested
    class UpdatePasswordTests {
        @Test
        void testUpdatePassword() {
            String newPassword = "newPassword";

            member.updatePassword(newPassword);

            assertEquals(newPassword, member.getPassword());
        }
    }

    @Nested
    class UpLevelTests {
        @Test
        void testUpLevel() {
            doReturn(true).when(member).isActive();
            doReturn(1).when(member).getLevel();

            member.upLevel();

            assertEquals(2, member.level);
        }

        @Test
        void testUpLevelNotActive() {
            doReturn(false).when(member).isActive();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.upLevel());
            assertEquals("用户未处于活跃状态, 无法获取等级分", exception.getMessage());
        }
    }

    @Nested
    class UpdateRankTests {
        @Test
        void testUpdateRank() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                doReturn(true).when(member).isActive();
                doReturn(memberStatistics).when(member).getMemberStatistics();

                member.updateRank(1);

                verify(memberStatistics).updateRank(1);

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }

        }

        @Test
        void testUpdateRankActive() {
            doReturn(false).when(member).isActive();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.updateRank(1));
            assertEquals("用户非活跃用户, 无法获取等级分", exception.getMessage());
        }
    }

    @Nested
    class DeleteTests {
        @Test
        void testDelete() {
            doReturn(false).when(member).hasStardust();

            member.delete();
        }

        @Test
        void testDeleteWithStardust() {
            doReturn(true).when(member).hasStardust();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.delete());
            assertEquals("用户未遣散星尘, 无法删除", exception.getMessage());
        }
    }

    @Nested
    class ReportTests {
        @Test
        void testReport() {
            doReturn(memberStatistics).when(member).getMemberStatistics();

            member.report();

            verify(memberStatistics).updateReportCount(1);
        }
    }

    @Nested
    class UpdateLikeCountTests {
        @Test
        void testUpdateLikeCount() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);
                doReturn(memberStatistics).when(member).getMemberStatistics();

                member.updateLikeCount(1);

                verify(memberStatistics).updateLikeCount(1);
                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }
    }

    @Nested
    class UpdateFanCountTests {
        @Test
        void testUpdateFanCount() {

            doReturn(memberStatistics).when(member).getMemberStatistics();

            member.updateFanCount(1);

            verify(memberStatistics).updateFanCount(1);
        }
    }

    @Nested
    class UpdateWorkCountTests {
        @Test
        void testUpdateWorkCount() {
            doReturn(memberStatistics).when(member).getMemberStatistics();

            member.updateWorkCount(1);

            verify(memberStatistics).updateWorkCount(1);
        }
    }

    @Nested
    class BanTests {
        @Test
        void testBan() {
            Integer banDuration = 30;

            doReturn(false).when(member).hasBanned();

            member.ban(banDuration);

            assertAll(
                    () -> assertNotNull(member.getBannedAt()),
                    () -> assertEquals(banDuration, member.getBanDuration())
            );
        }

        @Test
        void testBanAlreadyBanned() {
            doReturn(true).when(member).hasBanned();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.ban(30));
            assertEquals("用户已处于封禁状态", exception.getMessage());
        }
    }

    @Nested
    class UnbanTests {
        @Test
        void testUnban() {
            doReturn(true).when(member).hasBanned();

            member.unban();

            assertEquals(0, member.getBanDuration());
        }

        @Test
        void testUnbanNotBanned() {
            doReturn(false).when(member).hasBanned();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.unban());
            assertEquals("用户未处于封禁状态", exception.getMessage());
        }
    }

    @Nested
    class FollowTests {
        @Test
        void testFollow() {

            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                Long otherId = 1L;
                String otherName = "Other Member";
                doReturn(false).when(member).hasFollowed(otherId);
                doReturn(memberStatistics).when(member).getMemberStatistics();
                doReturn(new ArrayList<>()).when(member).getFollowMembers();

                member.follow(otherId, otherName);

                verify(member.getMemberStatistics()).updateFollowingCount(1);

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }

        }

        @Test
        void testFollowAlreadyFollowed() {
            Long otherId = 1L;
            String otherName = "Other Member";

            doReturn(true).when(member).hasFollowed(otherId);

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.follow(otherId, otherName));
            assertEquals("用户已关注过该用户", exception.getMessage());
        }
    }

    @Nested
    class UnfollowTests {
        @Test
        void testUnfollow() {
            try (MockedStatic<DomainEventSupervisorSupport> mockStatic = mockStatic(DomainEventSupervisorSupport.class)) {
                mockStatic.when(DomainEventSupervisorSupport::events).thenReturn(eventSupervisor);

                Long otherId = 1L;

                val list = new ArrayList<FollowMember>();
                list.add(FollowMember.builder().otherId(1L).build());

                doReturn(list).when(member).getFollowMembers();
                doReturn(memberStatistics).when(member).getMemberStatistics();

                member.unfollow(otherId);

                verify(member.getMemberStatistics()).updateFollowingCount(-1);

                verify(eventSupervisor).attach(any(), any());
                mockStatic.verify(DomainEventSupervisorSupport::events, times(1));
            }
        }

        @Test
        void testUnfollowNotFollowed() {
            Long otherId = 1L;
            doReturn(Collections.singletonList(followMember)).when(member).getFollowMembers();
            doReturn(2L).when(followMember).getOtherId();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.unfollow(otherId));
            assertEquals("关注用户不存在", exception.getMessage());
        }
    }

    @Nested
    class CreateFavoritesTests {
        @Test
        void testCreateFavorites() {
            String favoritesName = "Favorites1";
            String favoritesDesc = "Description";
            doReturn(false).when(member).hasUniqueFavorites(favoritesName);
            doReturn(new ArrayList<>()).when(member).getFavorites();

            member.createFavorites(favoritesName, favoritesDesc);

            assertFalse(member.getFavorites().isEmpty());
        }

        @Test
        void testCreateFavoritesAlreadyExists() {
            String favoritesName = "Favorites1";
            String favoritesDesc = "Description";
            doReturn(true).when(member).hasUniqueFavorites(favoritesName);

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.createFavorites(favoritesName, favoritesDesc));
            assertEquals("该用户已有同名收藏夹", exception.getMessage());
        }
    }

    @Nested
    class UpdateFavoritesInfoTests {
        @Test
        void testUpdateFavoritesInfo() {
            Long favoritesId = 1L;
            String favoritesName = "New Favorites Name";
            String favoritesDesc = "New Description";
            doReturn(Collections.singletonList(favorites)).when(member).getFavorites();
            doReturn(false).when(member).hasUniqueFavorites(favoritesName);
            doReturn(favoritesId).when(favorites).getId();

            member.updateFavoritesInfo(favoritesId, favoritesName, favoritesDesc);

            verify(favorites).updateInfo(favoritesName, favoritesDesc);
        }

        @Test
        void testUpdateFavoritesInfoUniqueAlreadyExists() {
            Long favoritesId = 1L;
            String favoritesName = "New Favorites Name";
            String favoritesDesc = "New Description";
            doReturn(true).when(member).hasUniqueFavorites(favoritesName);

            KnownException exception = assertThrows(KnownException.class, () -> member.updateFavoritesInfo(favoritesId, favoritesName, favoritesDesc));
            assertEquals("该用户已有同名收藏夹", exception.getMessage());
        }

        @Test
        void testUpdateFavoritesInfoNotFound() {
            Long favoritesId = 1L;
            String favoritesName = "New Favorites Name";
            String favoritesDesc = "New Description";
            doReturn(Collections.emptyList()).when(member).getFavorites();

            KnownException exception = assertThrows(KnownException.class, () -> member.updateFavoritesInfo(favoritesId, favoritesName, favoritesDesc));
            assertEquals("收藏夹不存在", exception.getMessage());
        }
    }

    @Nested
    class AddArticleToFavoriteTests {
        @Test
        void testAddArticleToFavorite() {
            Long favoritesId = 1L;
            Long articleId = 1L;
            doReturn(Collections.singletonList(favorites)).when(member).getFavorites();
            doReturn(favoritesId).when(favorites).getId();

            member.addArticleToFavorite(favoritesId, articleId);

            verify(favorites).addArticle(articleId);
            verify(favorites).updateArticleCount(1);
        }

        @Test
        void testAddArticleToFavoriteNotFound() {
            Long favoritesId = 1L;
            Long articleId = 1L;
            doReturn(Collections.emptyList()).when(member).getFavorites();

            KnownException exception = assertThrows(KnownException.class, () -> member.addArticleToFavorite(favoritesId, articleId));
            assertEquals("收藏夹不存在", exception.getMessage());
        }
    }

    @Nested
    class RemoveArticleFromFavoriteTests {
        @Test
        void testRemoveArticleFromFavorite() {
            Long favoritesId = 1L;
            Long articleId = 1L;
            doReturn(Collections.singletonList(favorites)).when(member).getFavorites();
            doReturn(favoritesId).when(favorites).getId();

            member.removeArticleFromFavorite(favoritesId, articleId);

            verify(favorites).removeArticle(articleId);
            verify(favorites).updateArticleCount(-1);
        }

        @Test
        void testRemoveArticleFromFavoriteNotFound() {
            Long favoritesId = 1L;
            Long articleId = 1L;
            doReturn(Collections.emptyList()).when(member).getFavorites();

            KnownException exception = assertThrows(KnownException.class, () -> member.removeArticleFromFavorite(favoritesId, articleId));
            assertEquals("收藏夹不存在", exception.getMessage());
        }
    }

    @Nested
    class DeleteFavoritesTests {
        @Test
        void testDeleteFavorites() {
            Long favoritesId = 1L;
            ArrayList<Favorites> list = new ArrayList<>();
            list.add(Favorites.builder()
                    .id(1L)
                    .build());

            doReturn(list).when(member).getFavorites();


            member.deleteFavorites(favoritesId);

            assertTrue(member.getFavorites().isEmpty());
        }

        @Test
        void testDeleteFavoritesNotFound() {
            Long favoritesId = 1L;
            doReturn(Collections.emptyList()).when(member).getFavorites();

            KnownException exception = assertThrows(KnownException.class,
                    () -> member.deleteFavorites(favoritesId));
            assertEquals("收藏夹不存在", exception.getMessage());
        }
    }

    @Nested
    class UpdateBlackInfoTests {
        @Test
        void testUpdateBlackInfo() {
            Long otherId = 1L;
            String otherName = "Other Member";
            doReturn(Collections.singletonList(blockMember)).when(member).getBlockMembers();
            doReturn(1L).when(blockMember).getOtherId();

            member.updateBlackInfo(otherId, otherName);

            verify(blockMember).update(otherName);
        }

        @Test
        void testUpdateBlackInfoOtherNotFound() {
            Long otherId = 1L;
            String otherName = "Other Member";
            doReturn(Collections.singletonList(blockMember)).when(member).getBlockMembers();
            doReturn(2L).when(blockMember).getOtherId();

            KnownException exception = assertThrows(KnownException.class, () -> member.updateBlackInfo(otherId, otherName));
            assertEquals("用户未屏蔽过该用户", exception.getMessage());
        }
    }

    @Nested
    class UpdateFollowInfoTests {
        @Test
        void testUpdateFollowInfo() {
            Long otherId = 1L;
            String otherName = "Other Member";
            doReturn(Collections.singletonList(followMember)).when(member).getFollowMembers();
            doReturn(1L).when(followMember).getOtherId();

            member.updateFollowInfo(otherId, otherName);

            verify(followMember).updateInfo(otherName);
        }

        @Test
        void testUpdateFollowInfoOtherNotFound() {
            Long otherId = 1L;
            String otherName = "Other Member";
            doReturn(Collections.singletonList(followMember)).when(member).getFollowMembers();
            doReturn(2L).when(followMember).getOtherId();

            KnownException exception = assertThrows(KnownException.class, () -> member.updateFollowInfo(otherId, otherName));
            assertEquals("关注用户不存在", exception.getMessage());
        }
    }
}
