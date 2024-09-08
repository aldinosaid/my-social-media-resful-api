package mysocialmedia.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mysocialmedia.restful.entity.User;
import mysocialmedia.restful.model.CreatePostRequest;
import mysocialmedia.restful.model.PostResponse;
import mysocialmedia.restful.model.RegisterUserRequest;
import mysocialmedia.restful.model.UpdatePostRequest;
import mysocialmedia.restful.model.WebResponse;
import mysocialmedia.restful.service.PostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class PostController {

    @Autowired
    private PostService postService;

     @PostMapping(
            path = "/api/posts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<PostResponse> createNewPost(User user, @RequestBody CreatePostRequest request) {
        PostResponse postResponse = postService.create(user, request);
        return WebResponse.<PostResponse>builder().data(postResponse).build();
    }

    // @PostMapping(
    //         path = "/api/posts/{id}",
    //         consumes = MediaType.APPLICATION_JSON_VALUE,
    //         produces = MediaType.APPLICATION_JSON_VALUE
    // )
    // public ResponseEntity<PostResponse> updatePost(
    //     User user,
    //     @RequestBody UpdatePostRequest request,
    //     @PathVariable("id") Long postId
    // ) {
    //     request.setId(postId);
    //     PostResponse postResponse = postService.update(user, request);
    //     return WebResponse.<PostResponse>builder().data(postResponse).build();
    // }
    
}
