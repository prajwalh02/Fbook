package com.example.FriendBook.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostResponse {

    String userName;       //get from user

    String content;

    String imageUrl;

    LocalDateTime createdAt;
}
