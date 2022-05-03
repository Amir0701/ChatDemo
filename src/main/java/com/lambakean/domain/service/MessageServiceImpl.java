package com.lambakean.domain.service;

import com.lambakean.data.model.Message;
import com.lambakean.data.model.User;
import com.lambakean.data.repository.MessageRepository;
import com.lambakean.domain.exception.InvalidEntityException;
import com.lambakean.domain.exception.UserNotLoggedInException;
import com.lambakean.representation.dto.MessageDto;
import com.lambakean.representation.dtoConverter.MessageDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.stream.Collectors;

@Component
public class MessageServiceImpl implements MessageService{
    private MessageDtoConverter messageDtoConverter;
    private MessageRepository messageRepository;
    private UserService userService;

    @Autowired
    public MessageServiceImpl(MessageDtoConverter messageDtoConverter,
                              MessageRepository messageRepository,
                              UserService userService){
        this.messageDtoConverter = messageDtoConverter;
        this.messageRepository = messageRepository;
        this.userService = userService;
    }


    @Override
    public MessageDto create(MessageDto messageDto, BindingResult bindingResult) {
        User user = userService.getCurrentUser();

        if(user == null) {
            throw new UserNotLoggedInException("You have to log in to create chats");
        }

        if(bindingResult.hasErrors()) {
            throw new InvalidEntityException(
                    bindingResult.getFieldErrors()
                            .stream()
                            .map(FieldError::getDefaultMessage)
                            .collect(Collectors.toSet())
            );
        }

        Message newMessage = messageDtoConverter.toMessage(messageDto);
        messageRepository.saveAndFlush(newMessage);
        return messageDto;
    }

    @Override
    public MessageDto delete(Long id) {
        Message message = messageRepository.getById(id);
        messageRepository.deleteById(id);
        MessageDto messageDto = messageDtoConverter.toMessageDto(message);
        return messageDto;
    }
}