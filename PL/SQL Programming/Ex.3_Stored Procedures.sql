--Scenario 1: Process monthly interest for all savings accounts.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'SAVINGS';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END ProcessMonthlyInterest;
/

--Scenario 2: Implement a bonus scheme for employees based on their performance.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN employees.department_id%TYPE,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonuses applied to department ' || p_department_id);
END UpdateEmployeeBonus;
/

--Scenario 3: Transfer funds between accounts with a balance check.
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN accounts.account_id%TYPE,
    p_target_account IN accounts.account_id%TYPE,
    p_amount IN NUMBER
) IS
    v_source_balance accounts.balance%TYPE;
BEGIN
    -- Fetch the balance of the source account
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account;

    -- Check if the source account has enough money
    IF v_source_balance >= p_amount THEN
        -- Deduct from source account
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account;

        -- Add to target account
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_target_account;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer successful.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in the source account.');
    END IF;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred during the transfer.');
END TransferFunds;
/