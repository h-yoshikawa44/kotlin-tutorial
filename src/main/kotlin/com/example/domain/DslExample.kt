import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    // データベースへの接続
    Database.connect(
        "jdbc:mysql://127.0.0.1:3306/exposed_example",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "mysql"
    )

    // トランザクションの定義
    transaction {
        // 標準ログ出力の有効化
        addLogger(StdOutSqlLogger)

        // INSERT 文の実行（get を使うと登録結果から指定のカラムの値を取得できる）
        val id = Member.insert {
            it[name] = "Kotlin"
        } get Member.id
        println("Inserted id: $id")

        // SELECT 文の実行
        val member = Member.select { Member.id eq id }.single()
        println("id: ${member[Member.id]}")
        println("name: ${member[Member.name]}")
    }
}

// Table クラスを継承し、テーブル構造に応じたプロパティを持ったオブジェクトを作成
object Member : Table("member") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 32)
}
