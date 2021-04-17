package ro.johann.dm.decision.api.transfer

import ro.johann.dm.decision.api.validation.NotBlankIfPresent

data class UpdateDecisionInput(

  @field:NotBlankIfPresent
  val name: String?,
  val description: String?
)