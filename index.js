const report = require("multiple-cucumber-html-reporter");

report.generate({
  // Ruta que pusimos en el plugin de TestRunner, donde se almacenan los resultados en un json
  jsonDir: "./target/cucumber_report/",
  reportPath: "./target/cucumber_report/",
  reportName: 'TEST RESULTS',
  openReportInBrowser: true,
  displayDuration: true,
  displayReportTime: true,

  metadata: {
    browser: {
      name: "chrome",
      version: "120",
    },
    device: "Local Test Machine",
    platform: {
      name: "windows",
      version: "10 pro",
    },
  },
  customData: {
    title: "Run Information",
    data: [
      {label: 'Account', value: 'AccountName'},
      {label: 'Project', value: 'ProjectName'},
      {label: 'Release', value: 'ReleaseVersion'},
      {label: 'Environment', value: 'EnvironmentValue'},
      {label: 'Execution Start Time', value: new Date().toLocaleString()},
    ],
  },
});