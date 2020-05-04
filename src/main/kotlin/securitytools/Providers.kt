package securitytools

import securitytools.Argument.argument
import java.security.Provider
import java.security.Security

class ProviderDetails(val provideName: String, val name: String)


class Providers(private val outputStrategy : OutputStrategy) {

    private val filter: String by argument()

    fun run(){
        listAllProviders()
    }


    private fun listAllProviders(){

        if(filter.isEmpty()) {
            getProviders().forEach {
                display(it)
            }
        }
        else{
            getFilteredProviders().forEach{ display("${it.provideName}: ${it.name}")}
        }
    }


    private fun display(provider: Provider) {
        outputStrategy.write(provider.name)

        outputStrategy.writeHeader()

        provider.entries.forEach { entry ->
            outputStrategy.write("\t ${entry.key}, ${entry.value}")
        }

        outputStrategy.writeFooter()

    }


    private fun display(message: String) {
        outputStrategy.write(message)
    }


    private fun getProviders(): List<Provider> {

        val providers = Security.getProviders()
        val list: List<Provider> = providers.asList()
        return list
    }

    private fun getFilteredProviders(): List<ProviderDetails> {
        return Security.getProviders().flatMap { provider ->
            provider.entries
                .filter { it -> it.key.toString().contains(filter, true) }
                .map { ProviderDetails(provider.name, it.key.toString()) }
        }
    }
}