package com.jyothsna.services.impl;

import com.jyothsna.entity.MyFriends;
import com.jyothsna.payloads.MyFriendsDto;
import com.jyothsna.repositories.MyFriendsRepository;
import com.jyothsna.services.MyFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyFriendsServiceImpl implements MyFriendsService {
    private MyFriendsRepository repository;

    @Autowired
    public MyFriendsServiceImpl(MyFriendsRepository repository) {
        this.repository = repository;
    }


    public void deleteFriend(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<MyFriendsDto> getAllFriends(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<MyFriends> myFriends = repository.findAll(pageable);
        List<MyFriendsDto> dto = myFriends.stream().map(friend -> mapToDto(friend)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public MyFriendsDto getFriendById(int id) {
        MyFriends myFriend = repository.findById(id).orElseThrow();
        return mapToDto(myFriend);
    }

    @Override
    public MyFriendsDto updateFriend(int id, MyFriendsDto friendsDto) {
        MyFriends myFriends = repository.findById(id).orElseThrow();
        myFriends.setFirstName(friendsDto.getFirstName());
        myFriends.setLastName(friendsDto.getLastName());
        myFriends.setMetDate(friendsDto.getMetDate());
        MyFriends friends = repository.save(myFriends);
        return mapToDto(friends);
    }

    @Override
    public MyFriendsDto createMyFriends(MyFriendsDto myFriendsDto) {
        MyFriends friends = mapToEntity(myFriendsDto);
        MyFriends newFriends = repository.save(friends);
        MyFriendsDto friendsDto = mapToDto(newFriends);
        return  friendsDto;

    }

    public MyFriendsDto mapToDto(MyFriends myFriends) {
        MyFriendsDto dto = new MyFriendsDto();
        dto.setId(myFriends.getId());
        dto.setFirstName(myFriends.getFirstName());
        dto.setLastName(myFriends.getLastName());
        dto.setMetDate(myFriends.getMetDate());
        return dto;
    }

    public MyFriends mapToEntity(MyFriendsDto friendsDto) {
        MyFriends friends = new MyFriends();
        friends.setId(friendsDto.getId());
        friends.setFirstName(friendsDto.getFirstName());
        friends.setLastName(friendsDto.getLastName());
        friends.setMetDate(friendsDto.getMetDate());
        return friends;
    }
}
