package com.lambakean.domain.service;

import com.lambakean.data.model.Chat;
import com.lambakean.representation.dto.ChatDto;
import com.lambakean.representation.dto.UserDto;
import org.springframework.validation.BindingResult;

public interface ChatService {

    ChatDto create(ChatDto chatData, BindingResult bindingResult);
    ChatDto delete(Long id);
    ChatDto get(Long id);
    //ChatDto update(ChatDto chatDto, BindingResult bindingResult);

    ChatDto[] getChatsByUserId(Long userId);

    ChatDto put(Long id, UserDto[] userDtos);

    ChatDto[] getAllChats();
}
