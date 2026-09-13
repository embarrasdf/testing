# Testing

A collection of Kotlin testing libraries and tools.

## `maindispatcher-extension`

A JUnit Jupiter Extension that sets `Dispatchers.Main` to a `TestDispatcher` for unit testing coroutines that use the Main dispatcher.

```kotlin
import com.embarrasdf.testing.MainDispatcherExtension
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MainDispatcherExtension::class)
class MainDispatcherTest {
    @Test
    fun `test coroutine with Main dispatcher`() = runTest {
        var result = ""
        launch(Dispatchers.Main) { result = "Hello from Main dispatcher" }
        assertEquals("Hello from Main dispatcher", result)
    }
}
```

[Source](maindispatcher-extension/src/main/kotlin/com/embarrasdf/testing/MainDispatcherExtension.kt)

### Setup

Add the following to your version catalog:

```toml
[versions]
maindispatcher-extension = "0.0.29"

[dependencies]
maindispatcher-extension = { group = "com.embarrasdf.testing", name = "maindispatcher-extension", version.ref = "maindispatcher-extension" }
```

Then add the following dependency to your `build.gradle.kts` file:

```kotlin
testImplementation(libs.maindispatcher.extension)
```

Or directly add the dependency in your `build.gradle.kts` file:

```kotlin
testImplementation("com.embarrasdf.testing:maindispatcher-extension:0.0.29")
```

## `maindispatcher-rule`

A JUnit 4 Rule that sets `Dispatchers.Main` to a `TestDispatcher` for unit testing coroutines that use the Main dispatcher.

```kotlin
import com.embarrasdf.testing.MainDispatcherRule
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MainDispatcherTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `test coroutine with Main dispatcher`() = runTest {
        var result = ""
        launch(Dispatchers.Main) { result = "Hello from Main dispatcher" }
        assertEquals("Hello from Main dispatcher", result)
    }
}
```

[Source](maindispatcher-rule/src/main/kotlin/com/embarrasdf/testing/MainDispatcherRule.kt)

### Setup

Add the following to your version catalog:

```toml
[versions]
maindispatcher-rule = "0.0.29"

[dependencies]
maindispatcher-rule = { group = "com.embarrasdf.testing", name = "maindispatcher-rule", version.ref = "maindispatcher-rule" }
```

Then add the following dependency to your `build.gradle.kts` file:

```kotlin
testImplementation(libs.maindispatcher.rule)
```

Or directly add the dependency in your `build.gradle.kts` file:

```kotlin
dependencies {
    testImplementation("com.embarrasdf.testing:maindispatcher-rule:0.0.29")
}
```
