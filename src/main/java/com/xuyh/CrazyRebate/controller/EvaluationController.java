package com.xuyh.CrazyRebate.controller;

import com.xuyh.CrazyRebate.model.Evaluation;
import com.xuyh.CrazyRebate.model.JsonResult;
import com.xuyh.CrazyRebate.model.User;
import com.xuyh.CrazyRebate.service.EvaluationService;
import com.xuyh.CrazyRebate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class EvaluationController {

    @Autowired
    private UserService userService;
    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping(value = "addEvaluation", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> addEvaluation(@RequestBody Evaluation evaluation, HttpServletRequest request) {
        JsonResult r = new JsonResult();
        User user= userService.OAuth(request);
        if(user==null){
            r.setStatus("003");
            r.setResult("no permission");
            return ResponseEntity.ok(r);
        }

        evaluation.setUserId(user.getId());
        evaluationService.addEvaluation(evaluation);
        r.setStatus("001");
        r.setResult("succeed");

        return ResponseEntity.ok(r);

    }

    @RequestMapping(value = "getEvaluations/{shareId}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getShareById (@PathVariable(value = "shareId") int shareId) {
        JsonResult r = new JsonResult();
        List<Evaluation>  evaluationList = evaluationService.getEvaluation(shareId);
        r.setStatus("001");
        r.setResult(evaluationList);
        return ResponseEntity.ok(r);
    }


}
