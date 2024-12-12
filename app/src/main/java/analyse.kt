import android.content.Context
import com.example.module03.R
import com.example.module03.models.User
import org.json.JSONObject

fun parseJson(context: Context): List<User> {
    val users = mutableListOf<User>()
    val jsonString = context.resources.openRawResource(R.raw.users).bufferedReader().use { it.readText() }
    val jsonArray = JSONObject(jsonString).getJSONArray("users")

    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        users.add(
            User(
                name = jsonObject.getString("name"),
                email = jsonObject.getString("email")
            )
        )
    }

    return users
}
