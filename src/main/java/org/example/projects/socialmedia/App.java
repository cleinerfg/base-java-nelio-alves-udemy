package org.example.projects.socialmedia;

import org.example.projects.socialmedia.entities.Comment;
import org.example.projects.socialmedia.entities.Post;

import java.time.Instant;
import java.time.OffsetDateTime;

public class App {

    public static void main(String[] args) {

        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that's awesome!");
        Comment c3 = new Comment("I'm jealous");
        Comment c4 = new Comment("Safe travels!");

        String inputDate = "2023-06-21T13:05:44-03:00";
        Instant timestamp = OffsetDateTime.parse(inputDate).toInstant();

        Post post = new Post("Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                timestamp);

        post.addComment(c1);
        post.addComment(c2);
        post.addComment(c3);

        post.addLike();
        post.addLike();
        post.addLike();


        System.out.println("--- Initial data ---");
        System.out.println(post);

        System.out.println("\n--- Updating data ---");
        post.removeLike();
        post.setContent("I'm going to visit South Island in New Zealand!");
        post.removeComment(c3);
        post.addComment(c4);

        System.out.println(post);
    }
}