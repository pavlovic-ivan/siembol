export const ADMIN_VERSION_FIELD_NAME = 'config_version';

export interface UiMetadataMap {
  [type: string]: UiMetadata;
}

export interface UiMetadata {
  name: string;
  version: string;
  author: string;
  description: string;
  labelsFunc: string;
  testing: TestConfig;
  perConfigSchemaPath: string;
  release: ReleaseConfig;
  unionType?: UnionType;
  disableEditingFeatures?: boolean;
}

export interface TestConfig {
  perConfigTestEnabled: boolean;
  releaseTestEnabled: boolean;
  testCaseEnabled: boolean;
}

export interface ReleaseConfig {
  version: string;
  config_array: string;
  extras?: string[];
}

export interface UnionType {
  unionPath: string;
  unionSelectorName: string;
}
