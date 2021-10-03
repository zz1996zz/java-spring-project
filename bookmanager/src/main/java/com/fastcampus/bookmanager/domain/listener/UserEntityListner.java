package com.fastcampus.bookmanager.domain.listener;

import com.fastcampus.bookmanager.domain.User;
import com.fastcampus.bookmanager.domain.UserHistory;
import com.fastcampus.bookmanager.repository.UserHistoryRepository;
import com.fastcampus.bookmanager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListner {

    @PostPersist
    @PostUpdate
    public void postPersistAndPostPersist(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }

}
