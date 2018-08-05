package com.ccfraser.muirwik.wrapper.table

import com.ccfraser.muirwik.wrapper.MButtonBaseProps
import com.ccfraser.muirwik.wrapper.createStyled
import com.ccfraser.muirwik.wrapper.setStyledPropsAndRunHandler
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler


@JsModule("@material-ui/core/TableRow")
private external val tableRowModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val tableRowComponent: RComponent<MTableRowProps, RState> = tableRowModule.default

interface MTableRowProps : MButtonBaseProps {
    var hover: Boolean
    var key: Any
    var onClick: (Event) -> Unit
    var selected: Boolean

}

fun RBuilder.mTableRow(
        key: Any? = null,
        selected: Boolean = false,
        hover: Boolean = false,
        onClick: ((Event) -> Unit)? = null,
        component: String = "tr",

        className: String? = null,
        handler: StyledHandler<MTableRowProps>? = null) = createStyled(tableRowComponent) {
    key?.let { attrs.key = key }
    attrs.component = component
    attrs.hover = hover
    onClick?.let { attrs.onClick = it }
    attrs.selected = selected

    setStyledPropsAndRunHandler(className, handler)
}