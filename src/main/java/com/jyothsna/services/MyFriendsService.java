package com.jyothsna.services;

import com.jyothsna.entity.MyFriends;
import com.jyothsna.payloads.MyFriendsDto;

import java.util.List;

public interface MyFriendsService {
    public MyFriendsDto createMyFriends(MyFriendsDto myFriendsDto);
    public void deleteFriend(int id);
    public List<MyFriendsDto> getAllFriends();
    public MyFriendsDto getFriendById(int id);
    public MyFriendsDto updateFriend(int id, MyFriendsDto friendsDto);
}
