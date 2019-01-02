# 建库
create database farmer default charset utf8 collate utf8_general_ci;
use farmer;

#建表:生产材料管理
create table t_user
(
  username varchar(20) not null
    primary key,
  password varchar(20) null,
  userType tinyint     not null
);

create table t_material
(
  materialName varchar(20) not null
    primary key,
  price        int         null comment '单价:种子以g计,原料以kg计,表中数据为现实数据*100,以加快计算速度.',
  materialType tinyint     null comment '种子为 0, 原料为 1.'
)
  comment '农业原料数据表';

create table purchase_record
(
  rId          int auto_increment
    primary key,
  materialName varchar(10) null,
  amount       int         null,
  purchaseDate date        null,
  remarks      varchar(20) null
)
  comment '生产材料购买记录';


# 建表: 配肥配药管理
create table t_ingredient
(
  id             int auto_increment
    primary key,
  ingredientName varchar(20) null
);

create table fertilizer
(
  id       int auto_increment
    primary key,
  fDate    date        null,
  fName    varchar(20) null,
  fee      int         null comment '劳务费',
  lossRate int         null comment '总重量损耗比'
);

create table fertilizer_ingredient
(
  fertilizerId int not null,
  ingredientId int not null,
  amount       int null,
  primary key (fertilizerId, ingredientId),
  constraint fertilizer_ingredient_fertilizer_id_fk
    foreign key (fertilizerId) references fertilizer (id)
      on update cascade on delete cascade,
  constraint fertilizer_ingredient_t_ingredient_id_fk
    foreign key (ingredientId) references t_ingredient (id)
      on update cascade on delete cascade
);


# 插入初始数据
insert into t_user(username, password, userType)
VALUES ('admin', '20181225', 1),
       ('tech', '20181225', 2),
       ('tech2', '20181225', 2),
       ('market', '20181225', 3),
       ('guest', '', 4);

insert into t_material(materialType, materialName, price)
VALUES (0, '番茄', 5),
       (0, '青椒', 4),
       (0, '牛心包菜', 3),
       (0, '黄瓜', 4),
       (0, '辣椒', 3),
       (0, '红薯尖', 5),
       (0, '白苋菜', 3),
       (0, '油麦菜', 4),
       (0, '四季豆', 5),
       (0, '甜玉米', 4),
       (0, '毛豆', 3),
       (0, '红苋菜', 4),
       (0, '黄秋葵', 3),
       (0, '西红柿', 4),
       (0, '茄子', 3),
       (0, '豆角', 4),
       (0, '丝瓜', 5),
       (0, '瓠子', 3),
       (0, '葫芦', 4),
       (0, '小南瓜', 5),
       (0, '西葫芦', 3),
       (0, '老南瓜', 3),
       (0, '平包', 5),
       (0, '小白菜', 4),
       (0, '生菜', 4),
       (0, '黄豆', 5),
       (0, '藕带', 4),
       (0, '莲子', 3),
       (0, '藕', 4),
       (1, '鸡粪', 5),
       (1, '马粪', 6),
       (1, '饼肥', 7),
       (1, '稻壳', 9),
       (1, '莲蓬壳', 10),
       (1, '稻草', 1),
       (1, '锯末', 2),
       (1, '树叶', 1);

insert into t_ingredient(ingredientName)
values ('鸡粪'),
       ('马粪'),
       ('饼肥'),
       ('稻壳'),
       ('莲蓬壳'),
       ('稻草'),
       ('锯末'),
       ('树叶');
