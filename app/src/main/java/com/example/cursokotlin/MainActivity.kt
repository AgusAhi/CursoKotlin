package com.example.cursokotlin

import Units
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.cursokotlin.ui.theme.*

import com.example.cursokotlin.Units.Unit5.*
import com.example.cursokotlin.Units.Unit6.*
import com.example.cursokotlin.Units.Unit7.*
import com.example.cursokotlin.Units.Unit8.*
import com.example.cursokotlin.Units.Unit9.*
import com.example.cursokotlin.Units.Unit10.*
import com.example.cursokotlin.Units.Unit11.*
import com.example.cursokotlin.Units.Unit12.*
import com.example.cursokotlin.Units.Unit13.*
import com.example.cursokotlin.Units.Unit14.*
import com.example.cursokotlin.Units.Unit15.*
import com.example.cursokotlin.Units.Unit16.*
import com.example.cursokotlin.Units.Unit17.*
import com.example.cursokotlin.Units.Unit18.*
import com.example.cursokotlin.Units.Unit19.*
import com.example.cursokotlin.Units.Unit20.*
import com.example.cursokotlin.Units.Unit21.*
import com.example.cursokotlin.Units.Unit22.*
import com.example.cursokotlin.Units.Unit23.*
import com.example.cursokotlin.Units.Unit24.*
import com.example.cursokotlin.Units.Unit25.*
import com.example.cursokotlin.ui.theme.CursoKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "com/example/cursokotlin/Units", // Define una ruta inicial
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        // Units page
                        composable("com/example/cursokotlin/Units") { Units(modifier = Modifier, navController = navController) }

                        // Unit 5
                        composable("Unit5") { Unit5(navController = navController) }
                        composable("Project10") { Project10(navController = navController) }
                        composable("Project11") { Project11(navController = navController) }
                        composable("Project12") { Project12(navController = navController) }
                        composable("Project13") { Project13(navController = navController) }
                        composable("Project14") { Project14(navController = navController) }

                        // Unit 6
                        composable("Unit6") { Unit6(navController = navController) }
                        composable("Project15") { Project15(navController = navController) }
                        composable("Project16") { Project16(navController = navController) }
                        composable("Project17") { Project17(navController = navController) }

                        // Unit 7
                        composable("Unit7") { Unit7(navController = navController) }
                        composable("Project18") { Project18(navController = navController) }
                        composable("Project19") { Project19(navController = navController) }
                        composable("Project20") { Project20(navController = navController) }
                        composable("Project21") { Project21(navController = navController) }
                        composable("Project22") { Project22(navController = navController) }

                        // Unit 8
                        composable("Unit8") { Unit8(navController = navController) }
                        composable("Project23") { Project23(navController = navController) }
                        composable ("Project24") { Project24(navController = navController) }
                        composable ("Project25") { Project25(navController = navController) }
                        composable ("Project26") { Project26(navController = navController) }
                        composable ("Project27") { Project27(navController = navController) }
                        composable ("Project28") { Project28(navController = navController) }
                        composable ("Project29") { Project29(navController = navController) }
                        composable ("Project30") { Project30(navController = navController) }

                        // Unit 9
                        composable("Unit9") { Unit9(navController = navController) }
                        composable("Project31") { Project31(navController = navController) }
                        composable("Project32") { Project32(navController = navController) }
                        composable("Project33") { Project33(navController = navController) }
                        composable("Project34") { Project34(navController = navController) }
                        composable("Project35") { Project35(navController = navController) }
                        composable("Project36") { Project36(navController = navController) }
                        composable("Project37") { Project37(navController = navController) }
                        composable("Project38") { Project38(navController = navController) }
                        composable("Project39") { Project39(navController = navController) }
                        composable("Project40") { Project40(navController = navController) }
                        composable("Project41") { Project41(navController = navController) }

                        // Unit 10
                        composable("Unit10") { Unit10(navController = navController) }
                        composable("Project42") { Project42(navController = navController) }
                        composable("Project43") { Project43(navController = navController) }
                        composable("Project44") { Project44(navController = navController) }
                        composable("Project45") { Project45(navController = navController) }
                        composable("Project46") { Project46(navController = navController) }

                        // Unit 11
                        composable("Unit11") { Unit11(navController = navController) }
                        composable("Project47") { Project47(navController = navController) }
                        composable("Project48") { Project48(navController = navController) }
                        composable("Project49") { Project49(navController = navController) }
                        composable("Project50") { Project50(navController = navController) }
                        composable("Project51") { Project51(navController = navController) }
                        composable("Project52") { Project52(navController = navController) }
                        composable("Project53") { Project53(navController = navController) }
                        composable("Project54") { Project54(navController = navController) }
                        composable("Project55") { Project55(navController = navController) }
                        composable("Project56") { Project56(navController = navController) }
                        composable("Project57") { Project57(navController = navController) }
                        composable("Project58") { Project58(navController = navController) }

                        // Unit 12
                        composable("Unit12") { Unit12(navController = navController) }
                        composable("Project59") { Project59(navController = navController) }
                        composable("Project60") { Project60(navController = navController) }
                        composable("Project61") { Project61(navController = navController) }
                        composable("Project62") { Project62(navController = navController) }
                        composable("Project63") { Project63(navController = navController) }
                        composable("Project64") { Project64(navController = navController) }
                        composable("Project65") { Project65(navController = navController) }

                        // Unit 13
                        composable("Unit13") { Unit13(navController = navController) }
                        composable("Project66") { Project66(navController = navController) }
                        composable("Project67") { Project67(navController = navController) }
                        composable("Project68") { Project68(navController = navController) }
                        composable("Project69") { Project69(navController = navController) }

                        // Unit 14
                        composable("Unit14") { Unit14(navController = navController) }
                        composable("Project70") { Project70(navController = navController) }
                        composable("Project71") { Project71(navController = navController) }
                        composable("Project72") { Project72(navController = navController) }
                        composable("Project73") { Project73(navController = navController) }

                        // Unit 15
                        composable("Unit15") { Unit15(navController = navController) }
                        composable("Project74") { Project74(navController = navController) }
                        composable("Project75") { Project75(navController = navController) }
                        composable("Project76") { Project76(navController = navController) }
                        composable("Project77") { Project77(navController = navController) }
                        composable("Project78") { Project78(navController = navController) }

                        // Unit 16
                        composable("Unit16") { Unit16(navController = navController) }
                        composable("Project79") { Project79(navController = navController) }
                        composable("Project80") { Project80(navController = navController) }
                        composable("Project81") { Project81(navController = navController) }
                        composable("Project82") { Project82(navController = navController) }
                        composable("Project83") { Project83(navController = navController) }
                        composable("Project84") { Project84(navController = navController) }

                        // Unit 17
                        composable("Unit17") { Unit17(navController = navController) }
                        composable("Project85") { Project85(navController = navController) }
                        composable("Project86") { Project86(navController = navController) }
                        composable("Project87") { Project87(navController = navController) }
                        composable("Project88") { Project88(navController = navController) }
                        composable("Project89") { Project89(navController = navController) }
                        composable("Project90") { Project90(navController = navController) }
                        composable("Project91") { Project91(navController = navController) }

                        // Unit 18
                        composable("Unit18") { Unit18(navController = navController) }
                        composable("Project92") { Project92(navController = navController) }
                        composable("Project93") { Project93(navController = navController) }

                        // Unit 19
                        composable("Unit19") { Unit19(navController = navController) }
                        composable("Project94") { Project94(navController = navController) }
                        composable("Project95") { Project95(navController = navController) }

                        // Unit 20
                        composable("Unit20") { Unit20(navController = navController) }
                        composable("Project96") { Project96(navController = navController) }
                        composable("Project97") { Project97(navController = navController) }

                        // Unit 21
                        composable("Unit21") { Unit21(navController = navController) }
                        composable("Project98") { Project98(navController = navController) }
                        composable("Project99") { Project99(navController = navController) }
                        composable("Project100") { Project100(navController = navController) }
                        composable("Project101") { Project101(navController = navController) }
                        composable("Project102") { Project102(navController = navController) }
                        composable("Project103") { Project103(navController = navController) }
                        composable("Project104") { Project104(navController = navController) }

                        // Unit 22
                        composable("Unit22") { Unit22(navController = navController) }
                        composable("Project105") { Project105(navController = navController) }
                        composable("Project106") { Project106(navController = navController) }
                        composable("Project107") { Project107(navController = navController) }
                        composable("Project108") { Project108(navController = navController) }

                        // Unit 23
                        composable("Unit23") { Unit23(navController = navController) }
                        composable("Project109") { Project109(navController = navController) }
                        composable("Project110") { Project110(navController = navController) }
                        composable("Project111") { Project111(navController = navController) }

                        // Unit 24
                        composable("Unit24") { Unit24(navController = navController) }
                        composable("Project112") { Project112(navController = navController) }
                        composable("Project113") { Project113(navController = navController) }
                        composable("Project114") { Project114(navController = navController) }
                        composable("Project115") { Project115(navController = navController) }
                        composable("Project116") { Project116(navController = navController) }

                        // Unit 25
                        composable("Unit25") { Unit25(navController = navController) }

                    }
                }
            }
        }
    }
}