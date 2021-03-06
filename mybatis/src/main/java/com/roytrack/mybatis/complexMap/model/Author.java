package com.roytrack.mybatis.complexMap.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by roytrack on 2016-09-17.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Author {
    private int authorId;
    private String authorUsername;
    private String authorPassword;
    private String authorEmail;
    private String authorBio;
    private String authorFavouriteSection;
}
