package cn.snow

/**
 * Created by Administrator on 05/16/2015.
 */

def process = "java -version".execute()
println(process)
println "Found text ${process.text}"

class Test {

}