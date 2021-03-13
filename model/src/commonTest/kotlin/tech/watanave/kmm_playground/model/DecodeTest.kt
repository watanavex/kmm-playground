package tech.watanave.kmm_playground.model

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DecodeTest {

    @Test
    fun testDecode() {
        val string = """
        {
          "id": 33569135,
          "node_id": "MDEwOlJlcG9zaXRvcnkzMzU2OTEzNQ==",
          "name": "RxSwift",
          "full_name": "ReactiveX/RxSwift",
          "private": false,
          "owner": {
            "login": "ReactiveX",
            "id": 6407041,
            "node_id": "MDEyOk9yZ2FuaXphdGlvbjY0MDcwNDE=",
            "avatar_url": "https://avatars.githubusercontent.com/u/6407041?v=4",
            "gravatar_id": "",
            "url": "https://api.github.com/users/ReactiveX",
            "html_url": "https://github.com/ReactiveX",
            "followers_url": "https://api.github.com/users/ReactiveX/followers",
            "following_url": "https://api.github.com/users/ReactiveX/following{/other_user}",
            "gists_url": "https://api.github.com/users/ReactiveX/gists{/gist_id}",
            "starred_url": "https://api.github.com/users/ReactiveX/starred{/owner}{/repo}",
            "subscriptions_url": "https://api.github.com/users/ReactiveX/subscriptions",
            "organizations_url": "https://api.github.com/users/ReactiveX/orgs",
            "repos_url": "https://api.github.com/users/ReactiveX/repos",
            "events_url": "https://api.github.com/users/ReactiveX/events{/privacy}",
            "received_events_url": "https://api.github.com/users/ReactiveX/received_events",
            "type": "Organization",
            "site_admin": false
          }
          "html_url": "https://github.com/ReactiveX/RxSwift",
          "description": "Reactive Programming in Swift",
          "fork": false,
          "url": "https://api.github.com/repos/ReactiveX/RxSwift",
          "forks_url": "https://api.github.com/repos/ReactiveX/RxSwift/forks",
          "keys_url": "https://api.github.com/repos/ReactiveX/RxSwift/keys{/key_id}",
          "collaborators_url": "https://api.github.com/repos/ReactiveX/RxSwift/collaborators{/collaborator}",
          "teams_url": "https://api.github.com/repos/ReactiveX/RxSwift/teams",
          "hooks_url": "https://api.github.com/repos/ReactiveX/RxSwift/hooks",
          "issue_events_url": "https://api.github.com/repos/ReactiveX/RxSwift/issues/events{/number}",
          "events_url": "https://api.github.com/repos/ReactiveX/RxSwift/events",
          "assignees_url": "https://api.github.com/repos/ReactiveX/RxSwift/assignees{/user}",
          "branches_url": "https://api.github.com/repos/ReactiveX/RxSwift/branches{/branch}",
          "tags_url": "https://api.github.com/repos/ReactiveX/RxSwift/tags",
          "blobs_url": "https://api.github.com/repos/ReactiveX/RxSwift/git/blobs{/sha}",
          "git_tags_url": "https://api.github.com/repos/ReactiveX/RxSwift/git/tags{/sha}",
          "git_refs_url": "https://api.github.com/repos/ReactiveX/RxSwift/git/refs{/sha}",
          "trees_url": "https://api.github.com/repos/ReactiveX/RxSwift/git/trees{/sha}",
          "statuses_url": "https://api.github.com/repos/ReactiveX/RxSwift/statuses/{sha}",
          "languages_url": "https://api.github.com/repos/ReactiveX/RxSwift/languages",
          "stargazers_url": "https://api.github.com/repos/ReactiveX/RxSwift/stargazers",
          "contributors_url": "https://api.github.com/repos/ReactiveX/RxSwift/contributors",
          "subscribers_url": "https://api.github.com/repos/ReactiveX/RxSwift/subscribers",
          "subscription_url": "https://api.github.com/repos/ReactiveX/RxSwift/subscription",
          "commits_url": "https://api.github.com/repos/ReactiveX/RxSwift/commits{/sha}",
          "git_commits_url": "https://api.github.com/repos/ReactiveX/RxSwift/git/commits{/sha}",
          "comments_url": "https://api.github.com/repos/ReactiveX/RxSwift/comments{/number}",
          "issue_comment_url": "https://api.github.com/repos/ReactiveX/RxSwift/issues/comments{/number}",
          "contents_url": "https://api.github.com/repos/ReactiveX/RxSwift/contents/{+path}",
          "compare_url": "https://api.github.com/repos/ReactiveX/RxSwift/compare/{base}...{head}",
          "merges_url": "https://api.github.com/repos/ReactiveX/RxSwift/merges",
          "archive_url": "https://api.github.com/repos/ReactiveX/RxSwift/{archive_format}{/ref}",
          "downloads_url": "https://api.github.com/repos/ReactiveX/RxSwift/downloads",
          "issues_url": "https://api.github.com/repos/ReactiveX/RxSwift/issues{/number}",
          "pulls_url": "https://api.github.com/repos/ReactiveX/RxSwift/pulls{/number}",
          "milestones_url": "https://api.github.com/repos/ReactiveX/RxSwift/milestones{/number}",
          "notifications_url": "https://api.github.com/repos/ReactiveX/RxSwift/notifications{?since,all,participating}",
          "labels_url": "https://api.github.com/repos/ReactiveX/RxSwift/labels{/name}",
          "releases_url": "https://api.github.com/repos/ReactiveX/RxSwift/releases{/id}",
          "deployments_url": "https://api.github.com/repos/ReactiveX/RxSwift/deployments",
          "created_at": "2015-04-07T21:25:17Z",
          "updated_at": "2021-03-13T01:55:33Z",
          "pushed_at": "2021-03-12T16:02:52Z",
          "git_url": "git://github.com/ReactiveX/RxSwift.git",
          "ssh_url": "git@github.com:ReactiveX/RxSwift.git",
          "clone_url": "https://github.com/ReactiveX/RxSwift.git",
          "svn_url": "https://github.com/ReactiveX/RxSwift",
          "homepage": "",
          "size": 15465,
          "stargazers_count": 19906,
          "watchers_count": 19906,
          "language": "Swift",
          "has_issues": true,
          "has_projects": true,
          "has_downloads": true,
          "has_wiki": true,
          "has_pages": false,
          "forks_count": 3573,
          "mirror_url": null,
          "archived": false,
          "disabled": false,
          "open_issues_count": 11,
          "license": {
            "key": "other",
            "name": "Other",
            "spdx_id": "NOASSERTION",
            "url": null,
            "node_id": "MDc6TGljZW5zZTA="
          },
          "forks": 3573,
          "open_issues": 11,
          "watchers": 19906,
          "default_branch": "main",
          "score": 1.0
        }
        """.trimIndent()

        val json = Json { ignoreUnknownKeys = true }
        val repo = json.decodeFromString<Repo>(string)
        assertEquals(Repo(
            33569135,
            "RxSwift",
            "ReactiveX/RxSwift",
            Owner(
                "ReactiveX",
                6407041,
                "https://avatars.githubusercontent.com/u/6407041?v=4"
            ),
            "https://github.com/ReactiveX/RxSwift",
            "Reactive Programming in Swift",
            "Swift",
            19906,
            19906,
            3573
        ), repo)
    }

}