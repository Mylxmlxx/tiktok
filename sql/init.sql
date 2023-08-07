CREATE TABLE user
(
    id               bigint auto_increment
        primary key,
    created_at       int                                                                    not null,
    updated_at       int                                                                    not null,
    deleted_at       int                                                                    null,
    name             varchar(255)                                                           not null,
    password         varchar(255)                                                           not null,
    follow_count     int          default 0                                                 null,
    follower_count   int          default 0                                                 null,
    avatar           varchar(255) default 'https://cdn.lhou.ltd/avatar/avatar.jpeg'         null,
    background_image varchar(255) default 'https://cdn.lhou.ltd/background/background.jpeg' null,
    signature        varchar(255) default '这是一个签名'                                    null,
    total_favorited  int          default 0                                                 null,
    work_count       int          default 0                                                 null,
    favorite_count   int          default 0                                                 null,
    constraint name
        unique (name)
);


-- auto-generated definition
CREATE TABLE video
(
    id             bigint auto_increment
        primary key,
    created_at     bigint           not null,
    updated_at     bigint           not null,
    deleted_at     bigint           null,
    author_id      bigint           not null,
    play_url       varchar(255)     not null,
    cover_url      varchar(255)     not null,
    favorite_count bigint default 0 null,
    comment_count  bigint default 0 null,
    title          varchar(255)     not null
);

CREATE TABLE message
(
    id           bigint auto_increment
        primary key,
    created_at   bigint not null,
    updated_at   bigint not null,
    deleted_at   bigint null,
    from_user_id bigint not null,
    to_user_id   bigint not null,
    content      text   null
);

CREATE TABLE follow
(
    id          bigint auto_increment
        primary key,
    created_at  bigint               not null,
    updated_at  bigint               not null,
    deleted_at  bigint               null,
    follow_id   bigint               not null,
    follower_id bigint               not null,
    is_follow   tinyint(1) default 0 null,
    is_mutual   tinyint(1) default 0 null
);


-- auto-generated definition
create table `like`
(
    id         bigint auto_increment
        primary key,
    created_at bigint        null,
    video_id   bigint        not null,
    user_id    bigint        not null,
    `status`   int default 0 not null
);


drop table comment


create table comment
(
    id         bigint auto_increment
        primary key,

    video_id   bigint not null,
    user_id    bigint not null,
    content    text   null,
    created_at bigint null,
    updated_at bigint null,
    deleted_at bigint null
);
