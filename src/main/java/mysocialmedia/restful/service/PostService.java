package mysocialmedia.restful.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.extern.slf4j.Slf4j;
import mysocialmedia.restful.entity.Post;
import mysocialmedia.restful.entity.User;
import mysocialmedia.restful.model.CreatePostRequest;
import mysocialmedia.restful.model.PostResponse;
import mysocialmedia.restful.model.UpdatePostRequest;
import mysocialmedia.restful.repository.PostRepository;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public PostResponse create(User user, CreatePostRequest request) {
        validationService.validate(request);

        Post post = new Post();
        post.setUser(user);
        post.setContent(request.getContent());
        post.setThumbnail(request.getThumbnail());
        post.setStatus(request.getStatus());
        post.setCreatedDate(new Date());
        postRepository.save(post);

        return toPostResponse(post);
    }

    @Transactional
    public PostResponse update(User user, UpdatePostRequest request) {
        validationService.validate(request);

        Post post = postRepository.findFirstByUserAndId(user, request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        post.setContent(request.getContent());
        post.setThumbnail(request.getThumbnail());
        post.setStatus(request.getStatus());
        post.setModifiedDate(new Date());
        postRepository.save(post);

        return toPostResponse(post);
    }

    private PostResponse toPostResponse(Post post)
    {
        return PostResponse.builder()
        .id(post.getId())
        .userId(post.getUser().getId())
        .content(post.getContent())
        .thumbnail(post.getThumbnail())
        // .createdDate(new Date())
        // .modifiedDate()
        .status(post.getStatus())
        .build();
    }
}
