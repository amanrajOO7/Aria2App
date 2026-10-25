package com.gianlu.aria2app.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AllInbox
import androidx.compose.material.icons.rounded.FileDownload
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.PlaylistAdd
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import com.gianlu.aria2app.R
import com.gianlu.aria2app.ui.theme.ActionBatchColor
import com.gianlu.aria2app.ui.theme.ActionMetalinkColor
import com.gianlu.aria2app.ui.theme.ActionSearchColor
import com.gianlu.aria2app.ui.theme.ActionTorrentColor
import com.gianlu.aria2app.ui.theme.ActionUriColor
import com.gianlu.aria2app.ui.theme.ActionWebViewColor
import com.gianlu.aria2app.ui.theme.AriaExpressiveTheme
import com.gianlu.aria2app.ui.theme.ExpressiveMotion
import com.gianlu.aria2app.ui.theme.ExpressivePillShape
import com.gianlu.aria2app.ui.theme.ExpressiveSquircleShape

interface ExpressiveFabController {
    fun collapse()
    fun expand()
    fun toggle()
    fun isExpanded(): Boolean
    fun setOnStateChangeListener(listener: OnFabStateChangeListener?)

    fun interface OnFabStateChangeListener {
        fun onStateChanged(expanded: Boolean)
    }
}

private data class FabActionItem(
    val title: String,
    val icon: ImageVector,
    val containerColor: Color,
    val contentColor: Color = contentColorFor(containerColor),
    val onClick: () -> Unit
)

// Picks black or white, whichever has the higher contrast against the container,
// so the chip labels stay readable on light colours such as amber.
private fun contentColorFor(container: Color): Color =
    if (container.luminance() > 0.179f) Color.Black else Color.White

@Composable
fun ExpressiveFabMenu(
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onSearch: () -> Unit,
    onAddUri: () -> Unit,
    onAddTorrent: () -> Unit,
    onAddMetalink: () -> Unit,
    onBatchAdd: () -> Unit,
    onWebView: () -> Unit,
    hasWebView: Boolean,
    modifier: Modifier = Modifier
) {
    val items = buildList {
        add(
            FabActionItem(
                title = stringResource(R.string.search),
                icon = Icons.Rounded.Search,
                containerColor = ActionSearchColor,
                onClick = onSearch
            )
        )
        add(
            FabActionItem(
                title = stringResource(R.string.batchAdd),
                icon = Icons.Rounded.AllInbox,
                containerColor = ActionBatchColor,
                onClick = onBatchAdd
            )
        )
        add(
            FabActionItem(
                title = stringResource(R.string.addMetalink),
                icon = Icons.Rounded.Link,
                containerColor = ActionMetalinkColor,
                onClick = onAddMetalink
            )
        )
        add(
            FabActionItem(
                title = stringResource(R.string.addTorrent),
                icon = Icons.Rounded.FileDownload,
                containerColor = ActionTorrentColor,
                onClick = onAddTorrent
            )
        )
        if (hasWebView) {
            add(
                FabActionItem(
                    title = stringResource(R.string.webView),
                    icon = Icons.Rounded.Language,
                    containerColor = ActionWebViewColor,
                    onClick = onWebView
                )
            )
        }
        add(
            FabActionItem(
                title = stringResource(R.string.addUri),
                icon = Icons.Rounded.PlaylistAdd,
                containerColor = ActionUriColor,
                onClick = onAddUri
            )
        )
    }

    val rotation by animateFloatAsState(
        targetValue = if (isExpanded) 135f else 0f,
        animationSpec = ExpressiveMotion.BouncySpring,
        label = "fab_rotation"
    )

    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Expressive Action Items
        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn(ExpressiveMotion.SnappySpring) + slideInVertically(
                animationSpec = ExpressiveMotion.bouncySpring(),
                initialOffsetY = { it / 2 }
            ),
            exit = fadeOut(ExpressiveMotion.SnappySpring) + slideOutVertically(
                animationSpec = ExpressiveMotion.snappySpring(),
                targetOffsetY = { it / 2 }
            )
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items.forEach { action ->
                    ExpressiveActionChip(action = action, onActionSelected = {
                        action.onClick()
                        onToggle()
                    })
                }
            }
        }

        // Main Expressive FAB
        FloatingActionButton(
            onClick = onToggle,
            shape = if (isExpanded) ExpressivePillShape else ExpressiveSquircleShape,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            elevation = FloatingActionButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 10.dp
            ),
            modifier = Modifier.size(56.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = if (isExpanded) stringResource(R.string.closeMenu) else stringResource(R.string.add),
                modifier = Modifier
                    .size(28.dp)
                    .rotate(rotation)
            )
        }
    }
}

@Composable
private fun ExpressiveActionChip(
    action: FabActionItem,
    onActionSelected: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        onClick = onActionSelected,
        shape = ExpressivePillShape,
        color = action.containerColor,
        contentColor = action.contentColor,
        shadowElevation = 4.dp,
        interactionSource = interactionSource
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
        ) {
            Icon(
                imageVector = action.icon,
                contentDescription = null,
                tint = action.contentColor,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = action.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = action.contentColor
            )
        }
    }
}

object ExpressiveFabMenuHelper {
    @JvmStatic
    fun setupExpressiveFab(
        composeView: ComposeView,
        lifecycleOwner: LifecycleOwner,
        onSearch: Runnable,
        onAddUri: Runnable,
        onAddTorrent: Runnable,
        onAddMetalink: Runnable,
        onBatchAdd: Runnable,
        onWebView: Runnable,
        hasWebView: Boolean
    ): ExpressiveFabController {
        val expandedState = mutableStateOf(false)
        var stateListener: ExpressiveFabController.OnFabStateChangeListener? = null

        val controller = object : ExpressiveFabController {
            override fun collapse() {
                if (expandedState.value) {
                    expandedState.value = false
                    stateListener?.onStateChanged(false)
                }
            }

            override fun expand() {
                if (!expandedState.value) {
                    expandedState.value = true
                    stateListener?.onStateChanged(true)
                }
            }

            override fun toggle() {
                val newState = !expandedState.value
                expandedState.value = newState
                stateListener?.onStateChanged(newState)
            }

            override fun isExpanded(): Boolean = expandedState.value

            override fun setOnStateChangeListener(listener: ExpressiveFabController.OnFabStateChangeListener?) {
                stateListener = listener
            }
        }

        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnLifecycleDestroyed(lifecycleOwner)
        )

        composeView.setContent {
            AriaExpressiveTheme {
                val isExpanded by expandedState
                ExpressiveFabMenu(
                    isExpanded = isExpanded,
                    onToggle = { controller.toggle() },
                    onSearch = { onSearch.run() },
                    onAddUri = { onAddUri.run() },
                    onAddTorrent = { onAddTorrent.run() },
                    onAddMetalink = { onAddMetalink.run() },
                    onBatchAdd = { onBatchAdd.run() },
                    onWebView = { onWebView.run() },
                    hasWebView = hasWebView
                )
            }
        }

        return controller
    }
}
