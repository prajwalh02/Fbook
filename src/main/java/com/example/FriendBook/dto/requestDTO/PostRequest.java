package com.example.FriendBook.dto.requestDTO;

import com.example.FriendBook.model.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostRequest {

    String content;

    String imageUrl;

    int userId;
}
