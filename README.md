# Ktor Tutorial
個人勉強用リポジトリ

教材出典：[Kotlin サーバーサイドプログラミング実践開発](https://gihyo.jp/book/2021/978-4-297-11859-4) ch10～12

## 環境立ち上げ
MySQL コンテナ立ち上げ
```bash
docker-compose up -d
```

サーバ起動  
Application.kt を実行

## データベース
コンテナに入る
```bash
docker-compose exec db bash
```

MySQL へログイン
```bash
mysql -h 127.0.0.1 --port 3306 -uroot -pmysql
```

### 初回セットアップ
データベース作成
```bash
create database exposed_example;
```

使用データベース選択
```bash
use exposed_example;
```

テーブル作成
```bash
CREATE TABLE member(
  id int NOT NULL AUTO_INCREMENT,
  name varchar(32) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
