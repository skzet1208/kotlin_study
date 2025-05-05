package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    BusinessCardApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(colorResource(R.color.oparl_green)),
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier
                .weight(3f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier
                    .width(120.dp)
                    .background(colorResource(R.color.oriental_blue))
            )
            Text(
                text = "Sample Name",
                fontSize = 36.sp,
                modifier = modifier.padding(top = 8.dp),
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.seagreen),
                modifier = modifier.padding(top = 8.dp)
            )
        }
        Column(modifier.weight(1f)) {
            DetailCompose(
                iconId = Icons.Default.Call,
                text = stringResource(R.string.tel),
                modifier = modifier,
            )
            DetailCompose(
                iconId = Icons.Default.Share,
                text = stringResource(R.string.github),
                modifier = modifier,
            )
            DetailCompose(
                iconId = Icons.Default.Email,
                text = stringResource(R.string.mail),
                modifier = modifier,
            )
        }
    }
}

@Composable
private fun DetailCompose(
    text: String,
    iconId: ImageVector,
    modifier: Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = iconId,
            contentDescription = null,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 12.dp),
            tint = colorResource(R.color.seagreen)
        )
        Text(
            text = text,
            fontSize = 14.sp,
            modifier = modifier.width(150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}