package org.example.projects.socialmedia.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    private String title;
    private Instant timestamp;
    private String content;
    private Integer likes = 0;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content, Instant timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addLike() {
        likes++;
    }

    public void removeLike() {
        if (likes > 0) {
            likes--;
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post{\n");
        sb.append("  title='").append(title).append("'\n");
        sb.append("  timestamp=").append(fmt.format(timestamp)).append("\n");
        sb.append("  content='").append(content).append("'\n");
        sb.append("  likes=").append(likes).append("\n");
        for (Comment c : comments) {
            sb.append("  comment='").append(c.getText()).append("'\n");
        }
        sb.append("}");
        return sb.toString();
    }
}