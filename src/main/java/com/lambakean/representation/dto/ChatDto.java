package com.lambakean.representation.dto;

import com.lambakean.data.model.Message;
import com.lambakean.data.model.Subscription;

import java.time.LocalDateTime;
import java.util.Set;

public class ChatDto {

    private Long id;
    private String name;
    private LocalDateTime whenCreated;
    private Set<SubscriptionDto> subscriptions;
    private Set<MessageDto> messages;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(LocalDateTime whenCreated) {
        this.whenCreated = whenCreated;
    }

    public Set<SubscriptionDto> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<SubscriptionDto> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageDto> messages) {
        this.messages = messages;
    }
}