# katalon_test_clean

Clean starter Katalon Studio project for Jenkins + ECS smoke testing.

## Included
- Minimal Katalon project metadata
- One smoke test: `TC_Jenkins2_Login_Reachable`
- One test suite: `Smoke`
- Jenkinsfile for ECS agent execution
- `.gitignore` that excludes transient artifacts

## Smoke test behavior
The test opens the Jenkins login page, waits for load, verifies the URL contains `login`, optionally checks for `Sign in`, captures a screenshot, and closes the browser.

It uses this environment variable when present:
- `TARGET_URL`

Default:
- `https://jenkins2-usw2a.awsc.leadfusion.com/login`

## Suggested repo creation and push
```bash
mkdir katalon_test_clean
cd katalon_test_clean
# copy these files in, then:
git init
git branch -M main
git remote add origin https://github.com/donmaslanka/katalon_test_clean.git
git add .
git commit -m "Initial clean Katalon smoke test project"
git push -u origin main
```

## Jenkins job
Point the Jenkins pipeline to this repo and keep the credential id:
- `katalon-api-key`

## Notes
If Katalon Studio rewrites the `.prj` file after opening locally, commit the rewritten version before testing in Jenkins.
