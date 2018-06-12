package br.com.zup.axon.bank.domain.account

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.axonframework.commandhandling.TargetAggregateIdentifier
import org.axonframework.serialization.Revision
import java.io.Serializable

data class RefundMoneyCommand(@field:TargetAggregateIdentifier val accountId: AccountId,
                              val transactionId: TransactionId,
                              val money: Money)
@Revision("1.0")
data class MoneyRefundedEvent @JsonCreator constructor(
        @JsonProperty("accountId") val accountId: AccountId,
        @JsonProperty("transactionId") val transactionId: TransactionId,
        @JsonProperty("money") val money: Money,
        @JsonProperty("balance") val balance: Money)

// it's necessary implement Serializable if you are going to schedule this event with Quartz
@Revision("1.0")
data class MoneyRefundRejectEvent @JsonCreator constructor(
        @JsonProperty("accountId") val accountId: AccountId,
        @JsonProperty("transactionId") val transactionId: TransactionId,
        @JsonProperty("money") val money: Money): Serializable
