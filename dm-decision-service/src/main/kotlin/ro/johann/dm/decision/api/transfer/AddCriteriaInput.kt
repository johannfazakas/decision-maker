package ro.johann.dm.decision.api.transfer

import ro.johann.dm.decision.domain.Criteria
import ro.johann.dm.decision.domain.Decision
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class AddCriteriaInput(

  @field:NotBlank
  val name: String,

  @field:Min(value = 0)
  @field:Max(value = 100)
  val weight: Int,

  val unitOfMeasure: String?,
) {
  fun toModel(decision: Decision): Criteria = Criteria(
    name = name,
    weight = weight,
    unitOfMeasure = unitOfMeasure,
    decision = decision,
  )
}