package com.developer.vijay.composesample.demos

import android.view.textclassifier.TextSelection
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import com.developer.vijay.composesample.R

@Composable
fun TextSelection1() {
    SelectionContainer {
        Column {
            Text(text = stringResource(id = R.string.selectable_text))
            DisableSelection {
                Text(text = stringResource(id = R.string.unselectable_text))
            }
            Text(text = stringResource(id = R.string.selectable_text))
            Text(text = stringResource(id = R.string.selectable_text))
        }
    }
}

@Composable
fun SuperScript() {
    Text(buildAnnotatedString {
        withStyle(SpanStyle(fontSize = MaterialTheme.typography.h6.fontSize)) {
            append(stringResource(id = R.string.hello))
        }
        withStyle(
            SpanStyle(
                fontSize = MaterialTheme.typography.h6.fontSize,
                baselineShift = BaselineShift.Superscript
            )
        ) {
            append(stringResource(id = R.string.world))
        }

    })
}

@Composable
fun SubScript() {
    Text(buildAnnotatedString {
        withStyle(SpanStyle(fontSize = MaterialTheme.typography.h6.fontSize)) {
            append(stringResource(id = R.string.hello))
        }
        withStyle(
            SpanStyle(
                fontSize = MaterialTheme.typography.h6.fontSize,
                baselineShift = BaselineShift.Subscript
            )
        ) {
            append(stringResource(id = R.string.world))
        }

    })
}