package com.curso.android.app.practica.cuadradofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.cuadradofinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CompareIfTrue() = runTest {
        val value = viewModel.comparateText("Primer test", "Primer test")
        assertTrue(value)
    }

    @Test
    fun mainViewModel_CompareIfFalse() = runTest {
        val value = viewModel.comparateText(
            "Segundo test",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras tincidunt massa eu felis aliquam, ut facilisis tellus volutpat. Duis non ante felis. Duis in molestie risus. Vestibulum consequat augue sed magna iaculis tristique. Sed ac commodo libero. Etiam interdum ornare mi. Proin quis sodales ligula. Nullam lobortis libero orci, sed ultrices odio tincidunt lobortis.\n" +
                    "\n" +
                    "In malesuada tristique odio blandit aliquam. Nullam id ante vehicula, consectetur augue sit amet, congue urna. Mauris euismod finibus massa, eget suscipit purus dignissim a. Aliquam interdum commodo nulla, id vehicula mi suscipit pharetra. Pellentesque placerat blandit fringilla. Sed molestie dui ut lobortis aliquet. In at suscipit ex, eu dictum lectus. Curabitur malesuada, nibh nec pulvinar semper, odio augue pellentesque risus, eget ultricies justo orci ac erat. Phasellus ullamcorper laoreet erat at commodo. Nullam at scelerisque orci. Sed in turpis leo. Ut gravida, nisi nec condimentum sollicitudin, lacus dui malesuada magna, mollis mollis lectus purus in enim. Nunc felis nisi, sollicitudin eu eros id, rhoncus euismod ante. Aliquam erat volutpat."
        )
        assertFalse(value)
    }
}