package mx.udg.cuvalles.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var operacion = ""
    var operacionPendiente = false
    var existeResultado = false

    lateinit var btn0:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button
    lateinit var btnC:Button
    lateinit var btnD:Button
    lateinit var btnM:Button
    lateinit var btnR:Button
    lateinit var btnS:Button
    lateinit var btnI:Button
    lateinit var etVisor:EditText
    lateinit var btnP:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniTUI()





    }

    private fun iniTUI(){
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnC = findViewById(R.id.btnC)
        btnD = findViewById(R.id.btnD)
        btnM = findViewById(R.id.btnM)
        btnR = findViewById(R.id.btnR)
        btnS = findViewById(R.id.btnS)
        btnI = findViewById(R.id.btnI)
        etVisor = findViewById(R.id.etVisor)
        btnP = findViewById(R.id.btnP)

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnC.setOnClickListener(this)
        btnD.setOnClickListener(this)
        btnM.setOnClickListener(this)
        btnR.setOnClickListener(this)
        btnS.setOnClickListener(this)
        btnI.setOnClickListener(this)
        etVisor.setOnClickListener(this)
        btnP.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn0->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("0")
            }
            R.id.btn1->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("1")
            }
            R.id.btn2->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("2")
            }
            R.id.btn3->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("3")
            }
            R.id.btn4->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("4")
            }
            R.id.btn5->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("5")
            }
            R.id.btn6->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("6")
            }
            R.id.btn7->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("7")
            }
            R.id.btn8->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("8")
            }
            R.id.btn9->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("9")
            }
            R.id.btnP->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append(".")
            }
            R.id.btnC->{
                limpiarPantalla()
            }
            R.id.btnD->{
                if(!operacionPendiente){
                    operacion = "division"
                    etVisor.append("/")
                    operacionPendiente = true
                }
            }
            R.id.btnM->{
                if(!operacionPendiente){
                    operacion = "multiplicacion"
                    etVisor.append("*")
                    operacionPendiente = true
                }
            }
            R.id.btnR->{
                if(!operacionPendiente){
                    operacion = "resta"
                    etVisor.append("-")
                    operacionPendiente = true
                }
            }
            R.id.btnS->{
                if(!operacionPendiente){
                    operacion = "suma"
                    etVisor.append("+")
                    operacionPendiente = true
                }
            }
            R.id.btnI->{
                if (operacionPendiente){
                    val textoOperacion = etVisor.text.toString()
                    var delimitador = ""
                    when (operacion){
                        "suma"->delimitador="+"
                        "resta"->delimitador="-"
                        "multiplicacion"->delimitador="*"
                        "division"->delimitador="/"
                    }

                    val operandos = textoOperacion.split(delimitador)
                    val operando1 = operandos[0].toDouble()
                    val operando2 = operandos[1].toDouble()
                    var resultado = 0.0
                    when(operacion){
                        "suma"->{
                            resultado=operando1+operando2
                        }
                        "resta"->{
                            resultado=operando1-operando2
                        }
                        "multiplicacion"->{
                            resultado=operando1*operando2
                        }
                        "division"->{
                            resultado=operando1/operando2
                        }
                    }
                    etVisor.setText("${resultado}")
                    existeResultado= true

                }
            }
        }
    }
    fun limpiarPantalla(){
        etVisor.setText("")
        operacionPendiente=false
        existeResultado= false

    }
}