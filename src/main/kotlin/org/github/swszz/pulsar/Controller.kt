package org.github.swszz.pulsar

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.pulsar.annotation.PulsarListener
import org.springframework.pulsar.core.PulsarTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class Controller(
    private val memberPulsarTemplate: PulsarTemplate<Member>,
) {

    @PostMapping("/members")
    @EventListener(ApplicationReadyEvent::class)
    fun createMember() {
        val member = Member("swszz", "swsz@kakao.com")
        memberPulsarTemplate.send("event.member", member)
    }

    @PulsarListener(topics = ["event.member"])
    fun listenMember(member: Member) {
        println("Received: $member")
    }
}