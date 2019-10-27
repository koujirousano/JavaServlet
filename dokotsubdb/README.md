# dokotsubdb

1. 以下のようなにDBを作成

```
CREATE DATABASE dokotsubu
DEFAULT CHARACTER SET UTF8;
```

2. 以下のようにテーブルを作成

```
CREATE TABLE mutters(
  id INT PRIMARY KEY AUTO_INCREMENT,
  userName VARCHAR(100),
  body TEXT
);
```
