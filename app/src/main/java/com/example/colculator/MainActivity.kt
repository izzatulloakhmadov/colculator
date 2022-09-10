package com.example.colculator


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.colculator.databinding.ActivityMainBinding
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {
    var working:String=""
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnone.setOnClickListener{
            oneClick()
        }
        binding.btntwo.setOnClickListener{
            twoClick()
        }
        binding.btnthree.setOnClickListener{
            threeClick()
        }
        binding.btnfour.setOnClickListener{
            fourClick()
        }
        binding.btnfive.setOnClickListener{
            fiveClick()
        }
        binding.btnsix.setOnClickListener{
            sixClick()
        }
        binding.btnseven.setOnClickListener{
            sevenClick()
        }
        binding.btneight.setOnClickListener{
            eightClick()
        }
        binding.btnnine.setOnClickListener{
            nineClick()
        }
        binding.btnzero.setOnClickListener{
            zeroClick()
        }
        binding.btnplus.setOnClickListener{
            plusClick()
        }
        binding.btnminus.setOnClickListener{
            minusClick()
        }
        binding.btnmultiply.setOnClickListener{
            multiplyClick()
        }
        binding.btndivide.setOnClickListener{
            divideClick()
        }
        binding.btnEqual.setOnClickListener{
            equal()
        }
        binding.btnclear.setOnClickListener {
            clear()
        }
        binding.btnbracket.setOnClickListener {
            setBracket()
        }
        binding.btndelete.setOnClickListener {
            deleteSingle()
        }
        with(binding) {
            with(txtScreen) {
                addTextChangedListener(object :TextWatcher{
                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        }


                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            equal()
                        }

                        /**
                         * This method is called to notify you that, somewhere within
                         * s, the text has been changed.
                         * It is legitimate to make further changes to s from
                         * this callback, but be careful not to get yourself into an infinite
                         * loop, because any changes you make will cause this method to be
                         * called again recursively.
                         * (You are not told where the change took place because other
                         * afterTextChanged() methods may already have made other changes
                         * and invalidated the offsets.  But if you need to know here,
                         * you can use [Spannable.setSpan] in [.onTextChanged]
                         * to mark your place and then look up from here where the span
                         * ended up.
                         */
                        override fun afterTextChanged(s: Editable?) {
                        }
                    })
            }
        }
    }
    fun setText(givenText:String){
        working += givenText
        binding.txtScreen.setText(working)
    }

    fun oneClick(){
        setText("1")
    }
    fun twoClick(){
        setText("2")
    }
    fun threeClick(){
        setText("3")
    }
    fun fourClick(){
        setText("4")
    }
    fun fiveClick(){
        setText("5")
    }
    fun sixClick(){
        setText("6")
    }
    fun sevenClick(){
        setText("7")
    }
    fun eightClick(){
        setText("8")
    }
    fun nineClick(){
        setText("9")
    }
    fun zeroClick(){
        setText("0")
    }
    fun plusClick(){
        setText("+")
    }
    fun minusClick(){
        setText("-")
    }
    fun multiplyClick(){
        setText("*")
    }
    fun divideClick(){
        setText("/")
    }
    fun equal(){
        var result:Double?=null
        val engine=ScriptEngineManager().getEngineByName("rhino")
        try {
            result=engine.eval(working) as Double?
        }
        catch(e:Exception){
            binding.txtResult.setText("")
        }
        if (result!=null){
            binding.txtResult.setText(result.toString())
        }
    }
    fun clear(){
        working=""
        binding.txtScreen.setText("0")
        binding.txtResult.setText("0")
    }
    var leftBracket=true
    fun setBracket(){
        if (leftBracket){
            setText("(")
            leftBracket=false
        }
        else{
            setText(")")
            leftBracket=true
        }
    }
    fun deleteSingle(){
        working=working.substring(0,working.length-1)
        binding.txtScreen.setText(working)
    }
}