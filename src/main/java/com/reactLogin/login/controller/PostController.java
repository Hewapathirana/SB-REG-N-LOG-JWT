package com.reactLogin.login.controller;

import com.reactLogin.login.model.Experience;
import com.reactLogin.login.model.Post;
import com.reactLogin.login.payload.ExprieneceRequest;
import com.reactLogin.login.payload.PostRequest;
import com.reactLogin.login.service.MapValidationErrorService;
import com.reactLogin.login.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<?> addPost(@Valid @RequestBody PostRequest postRequest, BindingResult result, Principal principal){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;

        Post post = postService.addPost(postRequest,principal);
        return  new ResponseEntity<Post>(post, HttpStatus.CREATED);

    }

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts(){
        List<Post> post = postService.getPost();
        return  new ResponseEntity<List>(post, HttpStatus.CREATED);

    }

    @GetMapping("/posts/{p_id}")
    public ResponseEntity<?> getPostById(@PathVariable String p_id){
        Optional<Post> post = postService.getPostById(p_id);
        return  new ResponseEntity<Optional>(post, HttpStatus.CREATED);

    }
}
