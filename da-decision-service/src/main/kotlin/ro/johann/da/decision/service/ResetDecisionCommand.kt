package ro.johann.da.decision.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ro.johann.da.decision.domain.Decision
import ro.johann.da.decision.domain.DecisionStatus
import ro.johann.da.decision.persistence.DecisionRepository
import ro.johann.da.decision.service.error.Errors
import java.time.LocalDateTime
import java.util.UUID

@Service
class ResetDecisionCommand(
  private val decisionRepository: DecisionRepository
) {
  private companion object {
    val logger: Logger = LoggerFactory.getLogger(ResetDecisionCommand::class.java)
  }

  fun execute(id: UUID): Decision {
    logger.info("reset decision >> decisionId = $id")

    val decision = decisionRepository.findByIdOrNull(id)
      ?: throw Errors.decisionNotFound(id)

    return decision
      .also {
        it.status = DecisionStatus.DESIGN
        it.updatedAt = LocalDateTime.now()
      }
      .let { decisionRepository.save(it) }
  }
}
