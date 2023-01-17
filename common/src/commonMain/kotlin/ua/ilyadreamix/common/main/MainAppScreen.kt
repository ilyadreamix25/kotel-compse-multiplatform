package ua.ilyadreamix.common.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ua.ilyadreamix.common.components.WithTooltip
import ua.ilyadreamix.common.core.AppTheme
import ua.ilyadreamix.common.strings.toStrings
import ua.ilyadreamix.common.utility.IfDesktop
import kotlin.system.exitProcess

private val mainNavigationDrawerItems = MainNavigationDrawerItem.asList()
val strings = Locale.current.toStrings()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen() {
    var themeSwitcherState by remember { mutableStateOf(false) }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var selectedNavItem by remember { mutableStateOf(mainNavigationDrawerItems[0]) }

    AppTheme(themeSwitcherState) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(16.dp)
        ) {
            ModalNavigationDrawer(
                drawerContent = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 24.dp,
                                bottom = 24.dp,
                                start = 12.dp,
                                end = 12.dp
                            ),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = strings.shortAppTitle,
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    bottom = 16.dp
                                ),
                                style = MaterialTheme
                                    .typography
                                    .titleSmall
                                    .copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )

                            mainNavigationDrawerItems.forEach { navigationDrawerItem ->
                                NavigationDrawerItem(
                                    label = { Text(text = navigationDrawerItem.label) },
                                    selected = navigationDrawerItem == selectedNavItem,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        selectedNavItem = navigationDrawerItem
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = navigationDrawerItem.icon,
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = strings.useDarkTheme,
                                style = MaterialTheme
                                    .typography
                                    .titleSmall
                                    .copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )
                            Switch(
                                checked = themeSwitcherState,
                                onCheckedChange = { themeSwitcherState = it }
                            )
                        }
                    }
                },
                drawerState = drawerState
            ) {
                MainScaffold(
                    currentDrawerItem = selectedNavItem,
                    modifier = Modifier.padding(8.dp),
                    onDrawerButtonClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScaffold(
    currentDrawerItem: MainNavigationDrawerItem,
    modifier: Modifier = Modifier,
    onDrawerButtonClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                actions = {
                    WithTooltip(strings.menu) {
                        IconButton(onClick = onDrawerButtonClick) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = null
                            )
                        }
                    }
                    IfDesktop {
                        WithTooltip(strings.close) {
                            IconButton(onClick = { exitProcess(0) }) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                },
                title = { Text(text = currentDrawerItem.label) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            MainNavHost(currentDrawerItem)
        }
    }
}
