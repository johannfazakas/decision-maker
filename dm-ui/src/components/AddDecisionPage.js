import React, { useState } from "react";
import { createDecision } from "../api/decisionsApi";

import DecisionForm from "./DecisionForm";

const AddDecisionPage = ({history}) => {
  const [errors, setErrors] = useState({});
  const [decision, setDecision] = useState({
    name: "",
    description: ""
  });

  const handleChange = ({target}) => {
    setDecision({
      ...decision,
      [target.name]: target.value
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    if (!formIsValid()) return;
    createDecision(decision)
      .then(_decision => {
        history.push("/decision/" + _decision.id + "/details")
      });
  };

  const formIsValid = () => {
    const _errors = {};
    if (!decision.name) _errors.name = "Name is required";
    setErrors(_errors);
    return Object.keys(_errors).length === 0;
  }

  const handleCancel = () => {
    history.push("/decisions");
  };

  return (
    <div className="jumbotron">
      <h2>New decision</h2>
      <DecisionForm
        decision={decision}
        errors={errors}
        onChange={handleChange}
        onSubmit={handleSubmit}
        onCancel={handleCancel}
      />
    </div>
  );
}

export default AddDecisionPage;