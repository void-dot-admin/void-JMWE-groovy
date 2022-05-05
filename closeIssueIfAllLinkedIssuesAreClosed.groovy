/**
 * JMWE Post-function that automatically closes an Issue:
 * when all Linked issues are closed (of a specific link type)
 * create a post-function using "Transition related issues (JMWE app)"
 * with the following configuration:
        - Transition(s): Trigger one of the following transitions (choose your transition)
        - Target issues:
            - Which issue(s): Issues linked to the current ...
            - Issue Link: choose the link type from where the automation is triggered
                *in my case "is child of"
            - Options: check every Skip *if you want to be fully automated
            - Conditional execution: check "Only if condition is true"
            - In the Condition Groovy console paste the code bellow & change it as you need
*/

def parent = issue.getLinkedIssues("is child of")?.getAt(0)
parent.getLinkedIssues("is parent of")?.findAll {it.issueType.name == "Requirement"}.every {it.status.name in ["Closed"]}