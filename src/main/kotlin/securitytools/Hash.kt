package securitytools

import java.security.MessageDigest
import securitytools.Argument.argument
import java.io.*
import java.util.*

class Hash(outputStrategy: OutputStrategy) : SecurityBase(outputStrategy) {


    private val logger by logger()


    companion object Help {
        fun help() {
            println("usage: java Hash -op 'hash' [-f filename]  [-d destfilename] [-p provider] [-a algorithm] [-o] [-encode]")
            println("\tf filename\t: read input data from filename")
            println("\td destfilename\t: write output hash to destfilename")
            println("\tp provider\t: use specific provider")
            println("\ta algorithm\t: algorithm to use for digest")
            println("\to\t\t: overwrite destfilename file")
            println("\te\t\t: BASE64 encode output")
        }
    }

    init {
        if(algorithm.isEmpty()) throw IllegalArgumentException()
    }

    override fun run() {
        val md = createDigestInstance(algorithm, provider)

        createInputStream(fileName).use { input ->
            createOutputStream(destFileName).use { output ->

                val hashedBytes = digestData(md, input)
                writeBytes(output, hashedBytes)
                logger.info("Data digested using ${md.algorithm} from ${md.provider}")
            }
        }
    }

    private fun digestData(md: MessageDigest, input: InputStream): ByteArray {
        val bytesToHash = readBytes(input)
        md.update(bytesToHash)
        return md.digest()
    }

    private fun createDigestInstance(algorithm: String, provider: String?): MessageDigest {

        return if (provider.isNullOrEmpty()) {
            MessageDigest.getInstance(algorithm)
        } else {
            MessageDigest.getInstance(algorithm, provider)
        }
    }

}