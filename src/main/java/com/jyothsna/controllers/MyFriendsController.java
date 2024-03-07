package com.jyothsna.controllers;

import com.jyothsna.entity.MyFriends;
import com.jyothsna.payloads.MyFriendsDto;
import com.jyothsna.services.MyFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
        @RequestMapping("/api/myFriends")
public class MyFriendsController {

    private MyFriendsService service;

    @Autowired
    public MyFriendsController(MyFriendsService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyFriendsDto> updateFriends(@PathVariable int id, @RequestBody MyFriendsDto friendsDto) {
        return new ResponseEntity<>(service.updateFriend(id, friendsDto), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<MyFriendsDto>> getAllFriends(
            @RequestParam(value = "pageNo", defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ) {
        return new ResponseEntity<>(service.getAllFriends(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyFriendsDto> getFriendById(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.getFriendById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<MyFriendsDto> createFriend(@RequestBody MyFriendsDto friendsDto) {
        return new ResponseEntity<MyFriendsDto>(service.createMyFriends(friendsDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public String deleteFriend(@PathVariable("id") int id) {
        service.deleteFriend(id);
        return "deleted";
    }

}
