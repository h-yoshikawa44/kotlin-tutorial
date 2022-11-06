import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
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

        // INSERT 文の実行
        val member = MemberEntity.new {
            name = "Kotlin"
        }
        println("Inserted id: ${member.id}")

        // SELECT 文の実行（Null 許容の Entity クラスを返すため、安全呼び出しと let でカラムの値を出力）
        MemberEntity.findById(member.id)?.let {
            println("id: ${it.id}")
            println("name: ${it.name}")
        }
    }
}

// Table クラスを継承（IntIdTable クラスは Table クラスの子クラスで、int 型の主キーを持つテーブルで使用する）
object MemberTable : IntIdTable("member") {
    val name = varchar("name", 32)
}

// Entity クラスを継承（IntEntity クラスは Entity クラスの子クラスで、int 型の主キーを持つテーブルで使用する）
class MemberEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MemberEntity>(MemberTable)
    // 主キー以外のカラムのフィールドを追加 + Table クラスの対応するカラムのフィールドにデリゲートする
    var name by MemberTable.name
}
