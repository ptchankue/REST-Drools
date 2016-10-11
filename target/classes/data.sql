
INSERT INTO APPLICATION_QUEUE(id, rule_name, application_type, queue_name, reason_code, result) VALUES (1,'RuleLoanAFF05', 'LOAN','AFF','AFF05', 'ID|CUSTDECL');
INSERT INTO APPLICATION_QUEUE(id, rule_name, application_type, queue_name, reason_code, result) VALUES (2,'RuleLoanAFF08','LOAN','AFF','AFF08', 'ID|PAYSLIP|PAYSLIP2|PAYSLIP3|PAYSLIP4|BANKSTM|CUSTDECL|BANKSNCA');
INSERT INTO APPLICATION_QUEUE(id, rule_name, application_type, queue_name, reason_code, result) VALUES (3,'RuleLoanAFF09','LOAN','AFF','AFF09', 'ID|PAYSLIP|PAYSLIP2|PAYSLIP3|PAYSLIP4|BANKSTM|CUSTDECL|BANKSNCA');
INSERT INTO APPLICATION_QUEUE(id, rule_name, application_type, queue_name, reason_code, result) VALUES (4,'RuleLoanAFF14','LOAN','AFF','AFF14', 'ID|PAYSLIP|PAYSLIP2|PAYSLIP3|PAYSLIP4|CUSTDECL');
INSERT INTO APPLICATION_QUEUE(id, rule_name, application_type, queue_name, reason_code, result) VALUES (5,'RuleLoanAFF15','LOAN','AFF','AFF15', 'ID|PAIDUPPEXPENDEC');
INSERT INTO APPLICATION_QUEUE(id, rule_name, application_type, queue_name, reason_code, result) VALUES (6,'RuleLoanAFF29','LOAN','AFF','AFF29', 'PAYSLIP|PAYSLIP2|PAYSLIP3|PAYSLIP4|CUSTDECL');


INSERT INTO product_variant(id, rule_name, product, variant, result) VALUES (1, 'RulePM_LOANPM_LOAN1', 'PM_LOAN', 'PM_NORMAL', '1');
INSERT INTO product_variant(id, rule_name, product, variant, result) VALUES (2, 'RulePM_CARDPM_NORMAL2', 'PM_CARD', 'PM_NORMAL', '2');
INSERT INTO product_variant(id, rule_name, product, variant, result) VALUES (3, 'RulePM_CARDLIMITINCREASEPM_NORMAL3', 'PM_CARDLIMITINCREASE', 'PM_NORMAL', '3');
INSERT INTO product_variant(id, rule_name, product, variant, result) VALUES (4, 'RulePM_CARDMIGRATIOMPM_NORMAL3', 'PM_CARDMIGRATIOM', 'PM_NORMAL', '3');

INSERT INTO credit_limit(id, card_type, num_credit_card, home_owner, result) VALUES (1, 'Student Gold', 'x', 'x', 2000);
INSERT INTO credit_limit(id, card_type, num_credit_card, home_owner, result) VALUES (2, 'Student Platinum', '<=2', 'x', 2500);
INSERT INTO credit_limit(id, card_type, num_credit_card, home_owner, result) VALUES (3, 'Student Platinum', '>2', 'x', 3500);


INSERT INTO mort_rules (rule_cond, rule_cons) values (
'interestRate < 7.94 && applicantIncome < 78223   ', 'setRisk(kcontext, $mortgage, 2.6)'
);
INSERT INTO mort_rules (rule_cond, rule_cons) values (
'interestRate < 7.19 && applicantIncome < 78223   ', 'setRisk(kcontext, $mortgage, 3.4)'
);