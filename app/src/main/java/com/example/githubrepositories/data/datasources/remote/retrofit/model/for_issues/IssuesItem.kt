package com.example.githubrepositories.data.datasources.remote.retrofit.model.for_issues

import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.ClosedBy
import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.Label
import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.PullRequest
import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.Reactions
import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.SubIssuesSummary
import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.User
import com.example.githubrepositories.data.datasources.remote.retrofit.model.unused.Assignee
import com.google.gson.annotations.SerializedName

data class IssuesItem(
    val active_lock_reason: Any,
    val assignee: Assignee,
    val assignees: List<Assignee>,
    val author_association: String,
    val body: String,
    val closed_at: Any,
    val closed_by: ClosedBy,
    val comments: Int,
    val comments_url: String,
    @SerializedName("created_at") val createdAt: String,
    val draft: Boolean,
    val events_url: String,
    val html_url: String,
    val id: Long,
    val labels: List<Label>,
    val labels_url: String,
    val locked: Boolean,
    val milestone: Any,
    val node_id: String,
    val number: Int,
    val performed_via_github_app: Any,
    val pull_request: PullRequest,
    val reactions: Reactions,
    @SerializedName("repository_url") val repositoryUrl: String,
    val state: String,
    val state_reason: Any,
    val sub_issues_summary: SubIssuesSummary,
    val timeline_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: User
)