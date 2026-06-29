--Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old.
DECLARE
    CURSOR c_customers IS 
        SELECT customer_id FROM customers WHERE age > 60;
BEGIN
    FOR v_cust IN c_customers LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE customer_id = v_cust.customer_id;
    END LOOP;
    
    COMMIT;
END;
/

--Scenario 2: Promote customers to VIP status based on a balance over $10,000.
DECLARE
    CURSOR c_accounts IS 
        SELECT customer_id, balance FROM accounts;
BEGIN
    FOR v_acc IN c_accounts LOOP
        IF v_acc.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = v_acc.customer_id;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/

--Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
DECLARE
    CURSOR c_due_loans IS
        SELECT customer_id, due_date 
        FROM loans 
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR v_loan IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_loan.customer_id || ', your loan is due on ' || TO_CHAR(v_loan.due_date, 'YYYY-MM-DD'));
    END LOOP;
END;
/