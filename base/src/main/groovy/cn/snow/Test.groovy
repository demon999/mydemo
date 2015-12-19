package cn.snow

/**
 * Created by Administrator on 05/16/2015.
 */

3.times {
    println("${it}")
}

def name1 = "richard"
def name2 = "richard-1"

println("$name1 -- $name2")
(name1,name2) = [name2,name1]
println("$name1 -- $name2")


def process = "java -version".execute()
println(process)
println "Found text ${process.text}"

